import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaPostComponent } from './pessoa-post.component';

describe('PessoaPostComponent', () => {
  let component: PessoaPostComponent;
  let fixture: ComponentFixture<PessoaPostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PessoaPostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PessoaPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
