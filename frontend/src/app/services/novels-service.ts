import { Injectable } from '@angular/core';
import { NovelDto } from '../models/novel-dto';
import { BehaviorSubject, map } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class NovelsService {
  novels = new BehaviorSubject<NovelDto[]>([
    {
      id: 0,
      title: 'The first ashes',
      description: 'A burning night',
    },
    {
      id: 1,
      title: 'Digging for survival',
      description: 'A young miners survival story',
    },
  ]);

  getNovelById(novelId: number) {
    return this.novels.pipe(
      map((novels) => {
        return novels.find((novel) => {
          if (novel.id === novelId) {
            return true;
          }
          return false;
        });
      }),
    );
  }
}
