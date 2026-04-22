import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NovelPageComponent } from "./pages/novel-page/novel-page";
import { NovelListPageComponent } from "./pages/novel-list-page/novel-list-page";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NovelPageComponent, NovelListPageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
