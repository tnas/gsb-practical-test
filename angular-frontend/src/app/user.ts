export class User {

  id: Number;
  firstName: string;
  lastName: string;
  email: string;

  constructor() {
    this.id = Date.now();
  }
}
