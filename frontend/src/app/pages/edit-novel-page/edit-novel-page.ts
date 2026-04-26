import { Component, signal } from '@angular/core';
import { ButtonComponent } from '../../shared-components/button/button';
import { form, FormField, minLength, required } from '@angular/forms/signals';

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
  formData = signal<EditNovelForm>({
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
}
