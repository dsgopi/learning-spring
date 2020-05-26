import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-enrollment',
  templateUrl: './enrollment.component.html',
  styleUrls: ['./enrollment.component.css']
})
export class EnrollmentComponent implements OnInit {

  @Input('first-name') firstName: String;
  @Input('last-name') lastName: String;
  @Input('country') selectedCountry: String;
  @Input('zip-code') zipCode?: number;
  @Input('email') email: String;
  @Input('password') password: String;

  constructor() { }

  ngOnInit(): void {
  }

}
