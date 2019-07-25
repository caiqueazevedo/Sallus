import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UsuarioListaComponent } from './usuario-lista/usuario-lista.component';
import { ProdutoListaComponent } from './produto-lista/produto-lista.component';
import { PedidoListaComponent } from './pedido-lista/pedido-lista.component';
import { UsuarioCriacaoComponent } from './usuario-criacao/usuario-criacao.component';
import { ProdutoCriacaoComponent } from './produto-criacao/produto-criacao.component';
import { PedidoCriacaoComponent } from './pedido-criacao/pedido-criacao.component';
import { UsuarioDetalhesComponent } from './usuario-detalhes/usuario-detalhes.component';
import { ProdutoDetalhesComponent } from './produto-detalhes/produto-detalhes.component';
import { PedidoDetalhesComponent } from './pedido-detalhes/pedido-detalhes.component';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioListaComponent,
    ProdutoListaComponent,
    PedidoListaComponent,
    UsuarioCriacaoComponent,
    ProdutoCriacaoComponent,
    PedidoCriacaoComponent,
    UsuarioDetalhesComponent,
    ProdutoDetalhesComponent,
    PedidoDetalhesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
