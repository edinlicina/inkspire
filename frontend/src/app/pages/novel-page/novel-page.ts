import { AsyncPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs';
import { NovelsService } from '../../services/novels-service';
import { ButtonComponent } from "../../shared-components/button/button";

@Component({
  selector: 'app-novel-page',
  templateUrl: './novel-page.html',
  styleUrl: './novel-page.css',
  imports: [AsyncPipe, ButtonComponent],
})
export class NovelPageComponent {
  novelsService = inject(NovelsService);
  route = inject(ActivatedRoute);
  router = inject(Router);
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

    deleteNovel(novelId: number){
      console.log("Hi");
      this.novelsService.deleteNovel(novelId).subscribe(() => {
        this.router.navigateByUrl("/");
      });
      
    }
     
}
