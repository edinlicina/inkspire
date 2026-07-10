import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { CreateNovelChapterDto } from '../models/create-novel-chapter-dto';
import { NovelChapterDto } from '../models/novel-chapter-dto';
import { UpdateNovelChapterDto } from '../models/update-novel-chapter-dto';

@Injectable({
  providedIn: 'root',
})
export class NovelChapterService {
  private readonly httpClient = inject(HttpClient);
  private readonly baseUrl = 'http://localhost:8080/api';

  getNovelChapters() {
    return this.httpClient.get<NovelChapterDto[]>(
      `${this.baseUrl}/novel-chapter`,
    );
  }

  getChapterById(chapterId: number) {
    return this.httpClient.get<NovelChapterDto>(
      `${this.baseUrl}/novel-chapter/${chapterId}`,
    );
  }

  createNovelChapter(novelId: number, dto: CreateNovelChapterDto) {
    return this.httpClient.post<NovelChapterDto>(
      `${this.baseUrl}/novel/${novelId}/chapters`,
      dto,
    );
  }

  updateNovelChapter(chapterId: number, dto: UpdateNovelChapterDto) {
    return this.httpClient.put<NovelChapterDto>(
      `${this.baseUrl}/novel-chapter/${chapterId}`,
      dto,
    );
  }

  deleteNovelChapter(chapterId: number) {
    return this.httpClient.delete<void>(
      `${this.baseUrl}/novel-chapter/${chapterId}`,
    );
  }
}
