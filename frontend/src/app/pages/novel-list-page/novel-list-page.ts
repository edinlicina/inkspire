import { Component, inject } from "@angular/core";
import { NovelPageComponent } from "../novel-page/novel-page";
import { RouterLink } from "@angular/router";
import { NovelDto } from "../../models/novel-dto";
import { NovelsService } from "../../services/novels-service";
import { AsyncPipe } from "@angular/common";

@Component({
    selector: "app-novel-list-page",
    templateUrl: "./novel-list-page.html",
    styleUrl: "./novel-list-page.css",
    imports: [AsyncPipe, RouterLink]
})
export class NovelListPageComponent{
    novelsService = inject(NovelsService); 
    novels = this.novelsService.novels;
}