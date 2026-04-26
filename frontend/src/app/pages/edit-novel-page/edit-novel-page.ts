import { Component, inject, signal } from '@angular/core';
import { ButtonComponent } from '../../shared-components/button/button';
import { form, FormField, minLength, required } from '@angular/forms/signals';
import { NovelsService } from '../../services/novels-service';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs';

type EditNovelForm = {
  id: number;
  title: string;
  description: string;
};

@Component({
  selector: 'app-edit-novel-page',
  templateUrl: './edit-novel-page.html',
  styleUrl: './edit-novel-page.css',
  imports: [ButtonComponent, FormField],
})
export class EditNovelPageComponent {
  novelsService = inject(NovelsService);
  route = inject(ActivatedRoute);
  router = inject(Router);
  formData = signal<EditNovelForm>({
    id: -1,
    title: '',
    description: '',
  });

  novel = this.route.params
    .pipe(
      map((params) => {
        console.log(params);
        return +params['novelId'];
      }),
      switchMap((novelId) => {
        return this.novelsService.getNovelById(novelId);
      }),
    )
    .subscribe((novel) => {
      this.form.id().value.set(novel.id);
      this.form.title().value.set(novel.title);
      this.form.description().value.set(novel.description);
    });

  form = form(this.formData, (path) => {
    minLength(path.title, 3, {
      message: 'Title must have at least 3 characters',
    });
    required(path.title, { message: 'Title is required.' });
    required(path.description, { message: 'A description is required.' });
  });

  wasFormSubmitted = signal(false);

  saveChanges() {
    this.wasFormSubmitted.set(true);
    if (this.form().invalid()) {
      return;
    }
    const novelId = this.form.id().value();
    const updatedNovelTitle = this.form.title().value();
    const updatedNovelDescription = this.form.description().value();

    this.novelsService
      .updateNovel(novelId, {
        title: updatedNovelTitle,
        description: updatedNovelDescription,
      })
      .subscribe((novel) => {
        this.router.navigateByUrl('novel/' + novel.id);
      });
  }
}
