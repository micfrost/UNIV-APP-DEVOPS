import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../models/product';


@Injectable({
    providedIn: 'root'
})
export class ProductService {
    private apiUrl = 'http://localhost:8080/api/products';

    constructor(private http: HttpClient) {
    }

// Metoda do pobierania wszystkich produktow
    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.apiUrl);
    }

  // Metoda do dodawania nowego produktu
  // uzywamy Omit, aby stworzyc typ bez pola id, bo jest ono generowane na backendzie
  addProduct(product: Omit<Product, 'id'>): Observable<Product> {
      return this.http.post<Product>(this.apiUrl, product);
  }
}
