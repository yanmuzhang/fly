package org.flyants.authorize.web.v1.platform;

import lombok.extern.slf4j.Slf4j;
import org.flyants.authorize.configuration.PageResult;
import org.flyants.authorize.domain.entity.platform.Menu;
import org.flyants.authorize.domain.service.MenuService;
import org.flyants.authorize.web.v1.platform.dto.MenuRootOptionsDto;
import org.flyants.authorize.web.v1.platform.dto.TreeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhangchao
 * @Date 2019/5/20 13:46
 * @Version v1.0
 */
@RestController
@RequestMapping(PlatformVersion.version + "/menu")
@Slf4j
public class MenuController {


    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<TreeDto> getTreeByParent(@RequestParam(required = false, name = "parentId") Long parentId) {
        List<Menu> rootMeuns = menuService.findListByParentId(parentId);
        return rootMeuns.stream().map(i -> new TreeDto(i.getName(), i.getId(),i.getParentId()!= null, new ArrayList<>())).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Menu get(@PathVariable("id") Long id) {
        return menuService.get(id);
    }

    @PostMapping
    public void add(@RequestBody Menu menu) {
        menuService.add(menu);
    }

    @PutMapping
    public void update(@RequestBody Menu menu) {
        menuService.update(menu);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        menuService.delete(id);
    }



}
