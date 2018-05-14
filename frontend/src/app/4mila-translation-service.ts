import {Injectable} from "@angular/core";
import {TranslationService} from "path-framework/app/path-framework/service/translation.service"

@Injectable()
export class _4milaTranslationService extends TranslationService {

    public getSupportedLanguageCodes() : string[] {
        return ["en", "de", "it", "nl"];
    }

    protected getTranslation(key:string) : string {
        let myTranslations = this.createTranslationMap(this.get4milaTranslations());
        // prefer custom translations
        if (myTranslations.get(key) == null) {
            return super.getTranslation(key);
        }
        return myTranslations.get(key);
    }

    private get4milaTranslations() {
        let languageCode: string = this.getUserLanguage();

        // put additional application translations here
        // TODO: switch on language if (languageCode == "de")
        return {
            "Admin": "Admin",
            "Controls": "Controls",
            "Courses": "Courses",
            "Classes": "Classes",
            "Entry": "Entry",
            "EditEvent": "Edit Event",
            "Event": "Event",
            "Name": "Name",
            "NewEvent": "New Event",
            "NotYetImplemented": "This function is not yet implemented.",
            "Results": "Results",
        }
    }
}