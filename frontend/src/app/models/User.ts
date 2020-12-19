import {Poster} from './Poster';

export interface User {
  id: string;
  username: string;
  password: string;
  email: string;
  firstName: string;
  lastName: string;
  rate: any;
  hasImage: boolean;
  address: string;
  posters: Poster[];
}
