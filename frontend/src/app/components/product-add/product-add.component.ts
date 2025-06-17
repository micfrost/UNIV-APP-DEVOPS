import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {ProductService} from '../../services/product.service';

@Component({
  selector: 'app-product-add',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './product-add.component.html',
  styleUrl: './product-add.component.css'
})
export class ProductAddComponent {
  productForm: FormGroup;
  // EventEmitter do powiadamiania komponentu rodzica o dodaniu produktu
  @Output() productAdded = new EventEmitter<void>

  constructor(
    private fb: FormBuilder,
    private productService: ProductService
  ) {
    this.productForm = this.fb.group(
      {
        name: ['', Validators.required],
        description: ['', Validators.required]
      });
  }

  onSubmit(): void {
    if (this.productForm.valid) {
      this.productService.addProduct(this.productForm.value).subscribe(() => {console.log('Produkt dodany pomyslnie.');
        this.productAdded.emit(); // Wyslij zdarzenie
        this.productForm.reset(); // Wyczysc formularz
      });
    }
  }
}
