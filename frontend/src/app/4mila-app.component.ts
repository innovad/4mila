import {Component, Type} from "@angular/core";
import {GuiModel} from "./gui-model/guimodel";
import {CustomPageElement} from "path-framework/app/path-framework/page/element/custom/custom-container.component";
import {TranslationService} from "path-framework/app/path-framework/service/translation.service";
import {PathService} from "path-framework/app/path-framework/service/path.service";
import {PathAppComponent} from "path-framework/app/path-framework/path-app.component";
import {_4milaTranslationService} from "./4mila-translation-service";

@Component({
    selector: "path-application",
    templateUrl: "./../../node_modules/path-framework/app/path-framework/path-app.component.html",
    // providers: [{ provide: path.PathService, useClass: path.PathMockService }]
    providers: [PathService, {provide: TranslationService, useClass: _4milaTranslationService}]
})

// tslint:disable-next-line:class-name
export class _4milaAppComponent extends PathAppComponent {

    private _appConfig = new GuiModel();

    constructor(pathService: PathService, translationService: TranslationService) {
        super(pathService, translationService);

        // Use WebSockets to handle events at ECard download station
        let webSocketUrl = this.getBackendUrl().replace("https", "wss");
        webSocketUrl = this.getBackendUrl().replace("http", "ws");
        webSocketUrl += "/websocket";
        const webSocket = new WebSocket(webSocketUrl, "ECardInsert");

        const app = this;
        webSocket.onmessage = function (event) {
            console.log("WebSocket Message from Server" + event.data);
            if (event.data === "download") {
                app.setCurrentPage("DownloadResultsPage", null);
            } else if (event.data === "registrationWithDB") {
                app.setCurrentPage("AddEntryPage", null);
            } else if (event.data === "registrationNewRunner") {
                app.setCurrentPage("AddEntryClassPage", null);
            }
        };
    }

    protected getFrontendVersion(): string {
        return "0.0.1-SNAPSHOT";
    }

    protected getStartPage(): string {
        return "mainmenu";
    }

    protected getApplicationLogo(): string {
        return null;
    }

    protected getOwnUserForm(): string {
        return "OwnUserForm";
    }

    protected getGuiModel() {
        if (this._appConfig != null) {
            return this._appConfig.guiModel;
        }
        return null;
    }

    public getBackendUrl() {
        if (window.location.hostname.indexOf("localhost") !== -1) {
            return "http://localhost:4567/services";
        }
        let url: string = window.location.href;
        url = url.replace("/#", "");
        if (url.indexOf("?") > 0) {
            url = url.substring(0, url.indexOf("?"));
        }
        if (url.endsWith("/")) {
            return url + "services";
        }
        return url + "/services";
    }

    protected getBeans() {
        return {};
    }

    protected getHandlers() {
        return {};
    }

}
