package com.reprezen.swaggerparser.val;

import static com.reprezen.swaggerparser.val.Messages.m;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableMap;
import com.reprezen.swaggerparser.jsonoverlay.std.BooleanOverlay;

public class BooleanValidator extends Validator<BooleanOverlay> {

    public static BooleanValidator validator = new BooleanValidator();

    @Override
    public void validate(BooleanOverlay overlay, ValidationResults results) {
        JsonNode json = overlay.getJson();
        if (!json.isMissingNode() && !json.isBoolean()) {
            results.addError(m.msg("NotBoolean|Value must be a boolean", json.getNodeType()));
        }
    }

    @Override
    public Map<? extends Validator<?>, String> getBeforeValidators() {
        return ImmutableMap.of(OverlayValidator.validator, NO_CRUMB);
    }

}