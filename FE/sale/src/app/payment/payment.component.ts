import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {PaymentService} from '../service/payment.service';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  id: number;
  p = 1;
  totalAmount = 0;
  products = [];
  inputData = '';
  isInputHidden = true;
  newProduct = {name: '', price: null, quantity: null, customerName: ''};
  paymentForm: FormGroup = new FormGroup({
    // customerId: new FormControl(),
    customerName: new FormControl(),
    phoneNumber: new FormControl(),
    address: new FormControl(),
    // dateOfBirthday: new FormControl(),
    email: new FormControl(),
    // productId: new FormControl(),
    // productName: new FormControl(),
    // price: new FormControl(),
    // quantity: new FormControl(),
    // totalAmount: new FormControl(),
    payments: new FormControl(),
    // bill: new FormControl()
  });
  productForm: FormGroup = new FormGroup({
    productName: new FormControl(),
    price: new FormControl(),
    quantity: new FormControl(),
    customerName: new FormControl()

  });

  constructor(private paymentService: PaymentService,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    if (this.id !== undefined) {
      this.paymentService.findById(this.id).subscribe(payment => {
        this.paymentForm = new FormGroup({
          // customerId: new FormControl('', [Validators.required]),
          customerName: new FormControl('', [Validators.required]),
          phoneNumber: new FormControl('', [Validators.required]),
          address: new FormControl('', [Validators.required]),
          // dateOfBirthday: new FormControl('', [Validators.required]),
          email: new FormControl('', [Validators.required]),
          // productId: new FormControl('', [Validators.required]),
          // productName: new FormControl('', [Validators.required]),
          // price: new FormControl('', [Validators.required]),
          // quantity: new FormControl('', [Validators.required]),
          // totalAmount: new FormControl('', [Validators.required]),
          payments: new FormControl('', [Validators.required]),
          // bill: new FormControl('', [Validators.required])
        });
      });
    }
    this.productForm = new FormGroup({
      productName: new FormControl(),
      quantity: new FormControl(),
      price: new FormControl(),
      customerName: new FormControl()
    });
  }

  savePayment() {
    const payment = this.paymentForm.value;
    this.paymentService.savePayment(payment).subscribe(response => {
    });
    this.productService.saveAllProduct(this.products).subscribe(response => {
    });
  }

  saveProduct() {
    // const products = this.productForm.value;
    const newId = this.products.length + 1;
    const newProduct = {id: newId, ...this.newProduct};
    this.products.push(newProduct);
    this.newProduct = {name: '', price: null, quantity: null, customerName: ''};
    this.calculateTotalAmount();
    // this.productService.saveProduct(products).subscribe(response => {
    // });
  }

  calculateTotalAmount() {
    this.totalAmount = this.products.reduce((total, product) => {
      return total + (product.price * product.quantity);
    }, 0);
  }

  toggleInputVisibility() {
    this.isInputHidden = !this.isInputHidden;
  }

}
