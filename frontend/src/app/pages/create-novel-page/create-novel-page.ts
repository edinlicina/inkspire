import { Component, inject, Inject, signal } from '@angular/core';
import { form, FormField } from '@angular/forms/signals';
import { NovelsService } from '../../services/novels-service';

type CreateNovelForm = {
  title: string;
  description: string;
};

@Component({
  selector: 'app-create-novel-page',
  templateUrl: './create-novel-page.html',
  styleUrl: './create-novel-page.css',
  imports: [FormField],
})
export class CreateNovelPageComponent {
  novelsService = inject(NovelsService);
  formData = signal<CreateNovelForm>({
    title: '',
    description: '',
  });
  form = form(this.formData);

  createNovel() {
    const formData = this.form().value();
    console.log(formData);
    this.novelsService
      .createNovel({
        title: formData.title,
        description: formData.description,
      })
      .subscribe();
    this.form().value.set({
      title: '',
      description: '',
    });
  }
}
