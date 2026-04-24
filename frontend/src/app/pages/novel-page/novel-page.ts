import { AsyncPipe, JsonPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs';
import { NovelsService } from '../../services/novels-service';

@Component({
  selector: 'app-novel-page',
  templateUrl: './novel-page.html',
  styleUrl: './novel-page.css',
  imports: [AsyncPipe],
})
export class NovelPageComponent {
  novelsService = inject(NovelsService);
  route = inject(ActivatedRoute);
  novel = this.route.params
    .pipe(
      map((params) => {
        console.log(params);
        return +params['novelId'];
      }),
      switchMap(novelId => {
        return this.novelsService.getNovelById(novelId);
      })
    )
     
}
