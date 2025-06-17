import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {ProductListComponent} from './components/product-list/product-list.component';
import {ProductAddComponent} from './components/product-add/product-add.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProductListComponent, ProductAddComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  protected title = 'univ-app-fe-angular-main-repo';
}
