import { Routes } from '@angular/router';
import { NovelListPageComponent } from './pages/novel-list-page/novel-list-page';
import { NovelPageComponent } from './pages/novel-page/novel-page';

export const routes: Routes = [
  {
    path: '',
    component: NovelListPageComponent,
  },
  {
    path: 'novel',
    component: NovelPageComponent,
  },
];
