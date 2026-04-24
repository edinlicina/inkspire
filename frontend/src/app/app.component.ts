import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { NovelPageComponent } from "./pages/novel-page/novel-page";
import { NovelListPageComponent } from "./pages/novel-list-page/novel-list-page";
import { NavbarComponent } from './shared-components/navbar/navbar';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NovelPageComponent, NovelListPageComponent, RouterLink, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
