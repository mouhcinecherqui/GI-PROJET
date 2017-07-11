import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListwithdetComponent } from './listwithdet.component';

describe('ListwithdetComponent', () => {
  let component: ListwithdetComponent;
  let fixture: ComponentFixture<ListwithdetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListwithdetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListwithdetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
