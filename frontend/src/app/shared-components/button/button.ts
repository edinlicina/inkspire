import { Component, input, output } from "@angular/core";

export type ButtonType = "button"|"submit";

@Component({
    selector: 'app-button',
    templateUrl: './button.html',
    styleUrl: './button.css'
})

export class ButtonComponent{

    type = input<ButtonType>("button");
    buttonClicked = output<void>();

    emitButtonClicked(){
        
        this.buttonClicked.emit();
    }
}