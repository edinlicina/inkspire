import { AsyncPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs';
import { NovelChapterService } from '../../services/novel-chapter-service';

@Component({
  selector: 'app-novel-chapter-page',
  imports: [AsyncPipe],
  templateUrl: './novel-chapter-page.html',
  styleUrl: './novel-chapter-page.css',
})
export class NovelChapterPageComponent {
  private route = inject(ActivatedRoute);
  private router = inject(Router);
  private novelChapterService = inject(NovelChapterService);

  novelId = Number(this.route.snapshot.paramMap.get('novelId'));

  chapter = this.route.paramMap.pipe(
    map((params) => Number(params.get('chapterId'))),
    switchMap((chapterId) =>
      this.novelChapterService.getChapterById(chapterId),
    ),
  );

  back() {
    this.router.navigate(['/novel', this.novelId]);
  }
}
