import { Component, inject, signal } from '@angular/core';
import { form, FormField, minLength, required } from '@angular/forms/signals';
import { ButtonComponent } from '../../shared-components/button/button';
import { NovelChapterService } from '../../services/novel-chapter-service';
import { ActivatedRoute, Router } from '@angular/router';

type CreateNovelChapterForm = {
  title: string;

  chapterNumber: number;

  content: string;
};

@Component({
  selector: 'app-create-novel-chapter-page',
  templateUrl: './create-novel-chapter-page.html',
  styleUrl: './create-novel-chapter-page.css',
  imports: [FormField, ButtonComponent],
})
export class CreateNovelChapterPageComponent {
  chapterService = inject(NovelChapterService);

  router = inject(Router);

  route = inject(ActivatedRoute);

  novelId = Number(this.route.snapshot.paramMap.get('novelId'));

  formData = signal<CreateNovelChapterForm>({
    title: '',

    chapterNumber: 1,

    content: '',
  });

  form = form(this.formData, (path) => {
    required(path.title, {
      message: 'Title is required.',
    });

    minLength(path.title, 3, {
      message: 'Title must have at least 3 characters.',
    });

    required(path.content, {
      message: 'Content is required.',
    });
  });

  wasFormSubmitted = signal(false);

  createChapter(event: Event) {
    event.preventDefault();

    this.wasFormSubmitted.set(true);

    const formData = this.form().value();

    if (this.form().invalid()) {
      return;
    }

    this.chapterService

      .createNovelChapter(this.novelId, {
        title: formData.title,

        chapterNumber: formData.chapterNumber,

        content: formData.content,
      })

      .subscribe(() => {
        this.router.navigateByUrl('novel/' + this.novelId);
      });
  }
}
