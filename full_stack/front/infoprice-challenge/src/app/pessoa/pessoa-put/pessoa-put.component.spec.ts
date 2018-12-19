import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaPutComponent } from './pessoa-put.component';

describe('PessoaPutComponent', () => {
  let component: PessoaPutComponent;
  let fixture: ComponentFixture<PessoaPutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaPutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
