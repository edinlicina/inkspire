import { inject, Injectable } from '@angular/core';
import { NovelDto } from '../models/novel-dto';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class NovelsService {
  httpClient = inject(HttpClient);

  getNovelById(novelId: number) {
    return this.httpClient.get<NovelDto>("http://localhost:8080/api/novel/" + novelId);
  }

  getNovels(){
    return this.httpClient.get<NovelDto[]>("http://localhost:8080/api/novel");
  }
}
