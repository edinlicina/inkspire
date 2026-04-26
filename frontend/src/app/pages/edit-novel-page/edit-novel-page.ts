import { Component, inject, signal } from '@angular/core';
import { ButtonComponent } from '../../shared-components/button/button';
import { form, FormField, minLength, required } from '@angular/forms/signals';
import { NovelsService } from '../../services/novels-service';
import { ActivatedRoute } from '@angular/router';
import { map, switchMap } from 'rxjs';

type EditNovelForm = {
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
  formData = signal<EditNovelForm>({
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

  anders(novelId: number) {
    this.novelsService.getNovelById(novelId);
  }
}
