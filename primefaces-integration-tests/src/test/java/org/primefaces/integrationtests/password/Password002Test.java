/*
 * The MIT License
 *
 * Copyright (c) 2009-2023 PrimeTek Informatics
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.primefaces.integrationtests.password;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.primefaces.selenium.AbstractPrimePage;
import org.primefaces.selenium.AbstractPrimePageTest;
import org.primefaces.selenium.component.Password;

// stability-issues for Firefox (96, 97) together with Selenium 4 and password.showFeedback
@Tag("FirefoxExclude")
class Password002Test extends AbstractPrimePageTest {

    @Test
    @Order(1)
    @DisplayName("Password: Show feedback panel with widget method")
    void feedbackShow(Page page) {
        // Arrange
        Password password = page.password;

        // Act
        password.showFeedback();

        // Assert
        WebElement feedback = password.getFeedbackPanel();
        assertEquals("block", feedback.getCssValue("display"));
        assertText(feedback, "Enter a password");
        assertConfiguration(password.getWidgetConfiguration());
    }

    @Test
    @Order(2)
    @DisplayName("Password: Hide feedback panel with widget method")
    void feedbackHide(Page page) {
        // Arrange
        Password password = page.password;
        password.showFeedback();

        // Act
        password.hideFeedback();

        // Assert
        WebElement feedback = password.getFeedbackPanel();
        assertEquals("none", feedback.getCssValue("display"));
        assertConfiguration(password.getWidgetConfiguration());
    }

    @Test
    @Order(3)
    @DisplayName("Password: Weak password")
    void feedbackWeak(Page page) {
        // Arrange
        Password password = page.password;

        // Act
        password.setValue("SOweak");
        password.showFeedback();

        // Assert
        WebElement feedback = password.getFeedbackPanel();
        assertText(feedback, "Weak");
        assertConfiguration(password.getWidgetConfiguration());
    }

    @Test
    @Order(4)
    @DisplayName("Password: Good password")
    void feedbackGood(Page page) {
        // Arrange
        Password password = page.password;

        // Act
        password.setValue("PrettyGood");
        password.showFeedback();

        // Assert
        WebElement feedback = password.getFeedbackPanel();
        assertText(feedback, "Medium");
        assertConfiguration(password.getWidgetConfiguration());
    }

    @Test
    @Order(5)
    @DisplayName("Password: Strong password")
    void feedbackStrong(Page page) {
        // Arrange
        Password password = page.password;

        // Act
        password.setValue("Very#Strong12345");
        password.showFeedback();

        // Assert
        WebElement feedback = password.getFeedbackPanel();
        assertText(feedback, "Strong");
        assertConfiguration(password.getWidgetConfiguration());
    }

    private void assertConfiguration(JSONObject cfg) {
        assertNoJavascriptErrors();
        System.out.println("Password Config = " + cfg);
        assertTrue(cfg.getBoolean("feedback"));
        assertFalse(cfg.getBoolean("inline"));
    }

    public static class Page extends AbstractPrimePage {
        @FindBy(id = "form:password")
        Password password;

        @Override
        public String getLocation() {
            return "password/password002.xhtml";
        }
    }
}
