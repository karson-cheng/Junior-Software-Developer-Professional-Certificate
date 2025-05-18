import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
selector: 'app-greeting',
        template: `<h1>Hello, Angular!</h1>`
        })
export class GreetingComponent {}


@Component({
  selector: 'app-product-list',
  template: `
    <div *ngFor="let product of products">
      <h2>{{ product.name }}</h2>
      <p>{{ product.description }}</p>
    </div>
  `
})
export class ProductListComponent implements OnInit {
  products: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('https://api.example.com/products')
      .subscribe(data => this.products = data);
  }
}