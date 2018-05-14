import {NgModule} from '@angular/core';
import {_4milaAppComponent} from './4mila-app.component';
import {AppModule} from 'path-framework/app/app.module';

@NgModule({
    imports:      [AppModule],
    declarations: [_4milaAppComponent],
    bootstrap:    [_4milaAppComponent],
    entryComponents: []
})
export class _4milaAppModule {}