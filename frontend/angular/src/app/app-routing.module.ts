import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProdutoListaComponent} from './produto-lista/produto-lista.component';
import {ProdutoCriacaoComponent} from './produto-criacao/produto-criacao.component';
import {ProdutoDetalhesComponent} from './produto-detalhes/produto-detalhes.component';



const routes: Routes = [
  { path: '', redirectTo: '/produtos', pathMatch: 'full'},
  { path: 'produtos', component: ProdutoListaComponent},
  { path: 'add', component: ProdutoCriacaoComponent},
  { path: 'detalhes/:id', component: ProdutoDetalhesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
