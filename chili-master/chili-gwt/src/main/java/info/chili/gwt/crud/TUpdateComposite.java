/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.chili.gwt.crud;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.utils.Utils;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public abstract class TUpdateComposite extends TCRUDComposite implements ClickHandler {
     Logger logger = Logger.getLogger(UpdateComposite.class.getName());
    public Button update = new Button("Update");

    public void initUpdateComposite(JSONObject entity, String className, final ConstantsWithLookup constants) {
        this.entity = entity;
        init(className, false, constants);
        entityCaptionPanel.addStyleName("y-gwt-UpdateEntityCaptionPanel");
        entityFieldsPanel.addStyleName("y-gwt-UpdateEntityDisplayWidget");
        basePanel.addStyleName("y-gwt-UpdateBasePanel");
        entityActionsPanel.add(update);
        update.addClickHandler(this);
        update.addStyleName("y-gwt-updateB");
        populateFieldsFromEntity(entity);
    }

    protected void initUpdateComposite(String id, String className, final ConstantsWithLookup constants) {
        this.entityId = id;
        init(className, false, constants);
        entityCaptionPanel.addStyleName("y-gwt-UpdateEntityCaptionPanel");
        entityFieldsPanel.addStyleName("y-gwt-UpdateEntityDisplayWidget");
        basePanel.addStyleName("y-gwt-UpdateBasePanel");
        entityActionsPanel.add(update);
        update.addClickHandler(this);
        loadEntity(entityId);
    }

    @Override
    public void onClick(ClickEvent event) {
        entity = populateEntityFromFields();
        if (processClientSideValidations(entity)) {
            if (event.getSource() == update) {
                updateButtonClicked();
                disableSubmitButtons();
            }
        }
    }

    public JSONObject getPopulatedEntity() {
        return populateEntityFromFields();
    }

    @Override
    protected void enterKeyPressed() {
        onClick(null);
    }

    @Override
    protected void enableSubmitButtons() {
        update.setEnabled(true);
    }

    @Override
    protected void disableSubmitButtons() {
        update.setEnabled(false);
    }

    protected void setButtonText(String key) {
        update.setText(Utils.getKeyValue(key, constants));
    }

    protected abstract JSONObject populateEntityFromFields();

    protected abstract void updateButtonClicked();

    public abstract void populateFieldsFromEntity(JSONObject entity);

    /**
     * override this method to handle any client side validation before calling
     * the server
     */
    protected boolean processClientSideValidations(JSONObject entity) {
        return true;
    }

    protected abstract void postUpdateSuccess(String result);

    public void loadEntity(String entityId) {
        throw new UnsupportedOperationException();
    }
}
