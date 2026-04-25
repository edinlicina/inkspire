import { Component, inject, Inject, signal } from '@angular/core';
import { form, FormField, required, schema } from '@angular/forms/signals';
import { NovelsService } from '../../services/novels-service';
import { Router } from '@angular/router';

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
  router = inject(Router);
  formData = signal<CreateNovelForm>({
    title: '',
    description: '',
  });
  form = form(this.formData, (path) => {
    required(path.title, {message: 'Title is required.'});
    required(path.description, {message: 'A description is required.'});
  });


  

  createNovel() {
    const formData = this.form().value();
    console.log(formData);
    if(this.form().invalid()){
      return;
    }
    this.novelsService
      .createNovel({
        title: formData.title,
        description: formData.description,
      })
      .subscribe((novel) => {
        this.router.navigateByUrl("novel/" + novel.id);
      });
    this.form().value.set({
      title: '',
      description: '',
    });
  }
}
