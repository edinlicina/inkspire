import { Component, inject, signal } from '@angular/core';
import { form, FormField, minLength, required } from '@angular/forms/signals';
import { NovelsService } from '../../services/novels-service';
import { Router } from '@angular/router';
import { ButtonComponent } from "../../shared-components/button/button";

type CreateNovelForm = {
  title: string;
  description: string;
};

@Component({
  selector: 'app-create-novel-page',
  templateUrl: './create-novel-page.html',
  styleUrl: './create-novel-page.css',
  imports: [FormField, ButtonComponent],
})
export class CreateNovelPageComponent {
  novelsService = inject(NovelsService);
  router = inject(Router);

  formData = signal<CreateNovelForm>({
    title: '',
    description: '',
  });

  form = form(this.formData, (path) => {
    minLength(path.title, 3, {
      message: 'Title must have at least 3 characters',
    });
    required(path.title, { message: 'Title is required.' });
    required(path.description, { message: 'A description is required.' });
  });

  wasFormSubmitted = signal(false);

  createNovel(event: Event) {
    event.preventDefault();

    this.wasFormSubmitted.set(true);
    const formData = this.form().value();
    console.log(formData);
    if (this.form().invalid()) {
      return;
    }
    this.novelsService
      .createNovel({
        title: formData.title,
        description: formData.description,
      })
      .subscribe((novel) => {
        this.router.navigateByUrl('novel/' + novel.id);
      });
    this.form().value.set({
      title: '',
      description: '',
    });
  }
}
