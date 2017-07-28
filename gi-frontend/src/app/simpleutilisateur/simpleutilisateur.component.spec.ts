import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimpleuserComponent } from './simpleuser.component';

describe('SimpleuserComponent', () => {
  let component: SimpleuserComponent;
  let fixture: ComponentFixture<SimpleuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimpleuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimpleuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
