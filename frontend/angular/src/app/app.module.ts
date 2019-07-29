import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProdutoListaComponent } from './produto-lista/produto-lista.component';
import { ProdutoCriacaoComponent } from './produto-criacao/produto-criacao.component';
import { ProdutoDetalhesComponent } from './produto-detalhes/produto-detalhes.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ProdutoListaComponent,
    ProdutoCriacaoComponent,
    ProdutoDetalhesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
