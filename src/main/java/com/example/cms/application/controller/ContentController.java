package com.example.cms.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;
import java.util.List;
import com.example.cms.application.service.ContentService;
import com.example.cms.domain.model.Content;
import com.example.cms.application.form.ContentForm;

/*
 * コンテンツの管理を行うコントローラー
 */
public class ContentController {
    
    @Autowired
    private ContentService contentService;

    @GetMapping("/contents")
    public String listContents(Model model) {
        List<Content> contents = contentService.findAll();
        model.addAttribute("contents", contents);
        return "contents/list";
    }
    @GetMapping("/contents/new")
    public String showCreateForm(Model model) {
        model.addAttribute("contentForm", new ContentForm());
        return "contents/form";
    }

    @PostMapping("/contents")
    public String createContent(@Valid @ModelAttribute("contentForm") ContentForm form,
                              BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "contents/form";
        }

        Content content = new Content();
        content.setName(form.getName());
        content.setDescription(form.getDescription());
        content.setOrigin(form.getOrigin());
        content.setColor(form.getColor());
        content.setShape(form.getShape());
        content.setSize(form.getSize());
        content.setWeight(form.getWeight());
        content.setMaterial(form.getMaterial());
        content.setActive(form.isActive());

        contentService.save(content);

        redirectAttributes.addFlashAttribute("successMessage", "コンテンツが正常に作成されました。");
        return "redirect:/contents";
    }

    @GetMapping("/contents/{id}")
    public String showContentDetail(@PathVariable Long id, Model model) {
        Content content = contentService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("無効なコンテンツID:" + id));
        model.addAttribute("content", content);
        return "contents/detail";
    }

    @GetMapping("/contents/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Content content = contentService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("無効なコンテンツID:" + id));
        model.addAttribute("contentForm", new ContentForm(content));
        return "contents/form";
    }

    @PostMapping("/contents/{id}")
    public String updateContent(@PathVariable Long id,
                              @Valid @ModelAttribute("contentForm") ContentForm form,
                              BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "contents/form";
        }

        Content content = contentService.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("無効なコンテンツID:" + id));

        content.setName(form.getName());
        content.setDescription(form.getDescription());
        content.setOrigin(form.getOrigin());
        content.setColor(form.getColor());
        content.setShape(form.getShape());
        content.setSize(form.getSize());
        content.setWeight(form.getWeight());
        content.setMaterial(form.getMaterial());
        content.setActive(form.isActive());

        contentService.save(content);

        redirectAttributes.addFlashAttribute("successMessage", "コンテンツが正常に更新されました。");
        return "redirect:/contents";
    }

}
