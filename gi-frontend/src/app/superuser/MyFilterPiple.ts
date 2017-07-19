import {User} from './user';
import {PipeTransform, Pipe} from '@angular/core';
@Pipe({
  name: 'myfilter',
  pure: false
})

export class MyFilterPipe implements PipeTransform {
  transform(users: any[], filter: string): any {
    if (!users || !filter) {
      return users;
    }
    return users.filter(user => user.lastName.toLocaleLowerCase().indexOf(filter) !== -1) ||
      users.filter(user => user.codeAlliance.toLocaleLowerCase().indexOf(filter) !== -1);
  }
}
