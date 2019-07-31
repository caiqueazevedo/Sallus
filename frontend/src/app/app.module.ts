import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProdutoListaComponent } from './produto/produto-lista/produto-lista.component';
import { ProdutoCriacaoComponent } from './produto/produto-criacao/produto-criacao.component';
import { ProdutoDetalhesComponent } from './produto/produto-detalhes/produto-detalhes.component';
import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';
import { UsuarioListaComponent } from './usuario/usuario-lista/usuario-lista.component';
import { UsuarioEditarComponent } from './usuario/usuario-editar/usuario-editar.component';
import { ProdutoEditarComponent } from './produto/produto-editar/produto-editar.component';
import { UsuarioDetalhesComponent } from './usuario/usuario-detalhes/usuario-detalhes.component';
import { UsuarioCriacaoComponent } from './usuario/usuario-criacao/usuario-criacao.component';
import { PedidoCriacaoComponent } from './pedido/pedido-criacao/pedido-criacao.component';
import { PedidoListaComponent } from './pedido/pedido-lista/pedido-lista.component';
import { PedidoDetalhesComponent } from './pedido/pedido-detalhes/pedido-detalhes.component';
import { PedidoEditarComponent } from './pedido/pedido-editar/pedido-editar.component';
import { HomeComponent } from './home/home.component';
import { AuthComponent } from './auth/auth.component';

@NgModule({
  declarations: [
    AppComponent,
    ProdutoListaComponent,
    ProdutoCriacaoComponent,
    ProdutoDetalhesComponent,
    LoginComponent,
    RegistroComponent,
    FooterComponent,
    HeaderComponent,
    UsuarioListaComponent,
    UsuarioEditarComponent,
    ProdutoEditarComponent,
    UsuarioDetalhesComponent,
    UsuarioCriacaoComponent,
    PedidoCriacaoComponent,
    PedidoListaComponent,
    PedidoDetalhesComponent,
    PedidoEditarComponent,
    HomeComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
