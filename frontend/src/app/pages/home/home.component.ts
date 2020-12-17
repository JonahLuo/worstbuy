import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  categoryList: string[] = [
    'Electronics', 'Computers', 'Toys',
    'Game Console', 'Video Game', 'Sports',
    'Smart Home', 'Out Doors'
  ];

  constructor() { }

  ngOnInit(): void {
  }

  search(content: string): void{
  }
}
