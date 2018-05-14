export class GuiModel {

    private _guiModel = {
        "application": {
            "title": "4mila",
            "formList": [
                {
                    "id": "OwnUserForm",
                    "title": "NotImplemented",
                    "formFieldList": [
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EventForm",
                    "title": "Event",
                    "url": "/event",
                    "formFieldList": [
                        {
                            "id": "name",
                            "type": "text",
                            "name": "Name",
                            "required": true,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
            ],
            "pageList": [
                {
                    "id": "mainmenu",
                    "name": "MainMenu",
                    "elementList": [
                        {
                            "type": "button",
                            "name": "Entry",
                            "icon": "fa-address-card",
                            "color": "carrot",
                            "page": "entriespage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Results",
                            "icon": "fa-list-ol",
                            "color": "pomegranate",
                            "page": "resultspage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Admin",
                            "icon": "fa-cog",
                            "color": "concrete",
                            "page": "adminpage",
                        },
                    ]
                },
                {
                    "id": "adminpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewEvent",
                            "width": 2,
                            "icon": "fa-calendar",
                            "color": "green",
                            "form": {
                                "form": "EventForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-calendar",
                            "color": "belize hole",
                            "search": false,
                            "url": "/event",
                            "form": {
                                "form": "EventForm",
                            }
                        }
                    ]
                },
            ]
        }
    };


    get guiModel() {
        return this._guiModel;
    }
}