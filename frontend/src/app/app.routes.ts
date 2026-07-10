import { Routes } from '@angular/router';
import { NovelListPageComponent } from './pages/novel-list-page/novel-list-page';
import { NovelPageComponent } from './pages/novel-page/novel-page';
import { CreateNovelPageComponent } from './pages/create-novel-page/create-novel-page';
import { EditNovelPageComponent } from './pages/edit-novel-page/edit-novel-page';
import { CreateNovelChapterPageComponent } from './pages/create-novel-chapter-page/create-novel-chapter-page';

export const routes: Routes = [
  {
    path: '',
    component: NovelListPageComponent,
  },
  {
    path: 'novel/:novelId',
    component: NovelPageComponent,
  },
  {
    path: 'create-novel',
    component: CreateNovelPageComponent,
  },
  {
    path: 'novel/:novelId/edit',
    component: EditNovelPageComponent,
  },
  {
    path: 'novel/:novelId/chapters/new',
    component: CreateNovelChapterPageComponent,
  },
];
