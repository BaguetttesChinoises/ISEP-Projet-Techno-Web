import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PreloadAllModules } from '@angular/router';

const routes: Routes = [
  { path: '', loadChildren: 'app/home/home.module#HomeModule' },
  { path: 'security', loadChildren: 'app/security/security.module#SecurityModule' },
  { path: 'trip', loadChildren: 'app/trip/trip.module#TripModule' },
  { path: 'proposals', loadChildren: 'app/proposals/proposals.module#ProposalsModule' },
  { path: 'account', loadChildren: 'app/account/account.module#AccountModule'},
  { path: 'statics', loadChildren: 'app/statics/statics.module#StaticsModule' },

  { path: '**', redirectTo: '', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})],
  exports: [RouterModule]
})
export class AppRouting { }
