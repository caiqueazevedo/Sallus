import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProdutoListaComponent} from './produto/produto-lista/produto-lista.component';
import {ProdutoCriacaoComponent} from './produto/produto-criacao/produto-criacao.component';
import {ProdutoDetalhesComponent} from './produto/produto-detalhes/produto-detalhes.component';
import {ProdutoEditarComponent} from "./produto/produto-editar/produto-editar.component";



const routes: Routes = [
  { path: '', redirectTo: '/produtos', pathMatch: 'full'},
  { path: 'produtos', component: ProdutoListaComponent},
  { path: 'add', component: ProdutoCriacaoComponent},
  { path: 'detalhes/:id', component: ProdutoDetalhesComponent},
  { path: 'editar/:id', component: ProdutoEditarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
