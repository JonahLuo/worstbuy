import {User} from './User';
import {Poster} from './Poster';

export class Transaction{
  id: string;
  date: Date;
  buyer: User;
  seller: User;
  status: string;
  poster: Poster;

  constructor() {
  }
}
