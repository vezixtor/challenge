import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutModule } from './layout/layout.module';
import { ApiHttpClient } from './shared/api.http.client';
import { EnderecoFormComponent } from './endereco/endereco-form/endereco-form.component';
import { EstadoService } from './service/estado.service';
import { FormsModule } from '@angular/forms';
import { CidadeService } from './service/cidade.service';

@NgModule({
  declarations: [
    AppComponent,
    EnderecoFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    LayoutModule
  ],
  providers: [
    ApiHttpClient,
    EstadoService,
    CidadeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
