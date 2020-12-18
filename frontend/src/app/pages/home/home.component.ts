import { Component, OnInit } from '@angular/core';
import {Categories} from '../../models/Categories';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  categoryList = Categories;

  constructor() { }

  ngOnInit(): void {
  }

  search(content: string): void{
  }
}
