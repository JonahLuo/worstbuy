import {User} from './User';

export class Poster{
  id: string;
  seller: User;
  title: string;
  subTitle: string;
  price: any;
  category: string;
  tag: string;
  brand: string;
  modifyDate: Date;
  createDate: Date;
  isClose = false;
  hasImage = false;
  description: string;


  constructor() {
  }
}
