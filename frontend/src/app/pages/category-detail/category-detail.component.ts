import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PosterService} from '../../server/poster.service';
import {Poster} from '../../models/Poster';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.scss']
})
export class CategoryDetailComponent implements OnInit {

  itemlist: Poster[] = []

  constructor(private route: ActivatedRoute,
              private router: Router,
              private posterService: PosterService) { }

  ngOnInit(): void {
    this.getItemList(this.route.snapshot.paramMap.get('category'));
  }

  getItemList(category: string): void {
    this.posterService.getPostersByCategory(category).subscribe(
      posters => this.itemlist = posters);
  }
}
