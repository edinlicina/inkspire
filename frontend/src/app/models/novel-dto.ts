import { NovelChapterDto } from './novel-chapter-dto';

export type NovelDto = {
  id: number;
  title: string;
  description: string;
  chapters: NovelChapterDto[];
};
